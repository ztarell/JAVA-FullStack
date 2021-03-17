import { store } from '@risingstack/react-easy-state'
 
async function parseJson(response) {
    const jsonData = []
    const rawData = await response.text()
    rawData.split("\n")
        .forEach((jsonString) => {
            if ( (jsonString.length > 0) ) {
                try {
                    jsonData.push(JSON.parse(jsonString))
                } catch (error) {
                    console.error(error)
                }
            }
        })
 
    return jsonData
}
 
function getTimeInfo(reviewTime) {
    const rawTimeInfo = reviewTime.toString()
    let timeInfo, reviewYear, reviewMonth, reviewDay
    if ( rawTimeInfo.length > 0 ) {
        timeInfo = rawTimeInfo.split(', ')
        reviewYear = timeInfo[1].toString()
        timeInfo = timeInfo[0].toString().split(' ')
        reviewMonth = timeInfo[0].toString()
        reviewDay = timeInfo[1].toString()
        return [ reviewYear, reviewMonth, reviewDay ]
 
    } else {
        return [ 'UNKNOWN_YEAR', 'UNKNOWN_MONTH', 'UNKNOWN_DAY' ]
    }
}
 
const reviewStore = store({
    reviews: [],
    async loadData(jsonUrl) {
        const response = await fetch(jsonUrl)
        const jsonData = await parseJson(response)
        reviewStore.reviews = jsonData
    },
 
    getReviewCountByMonth() {
        const reviewCountByMonth = {}
        reviewStore.reviews.forEach((review)=> {
            const [ year, month, ] = getTimeInfo(review.reviewTime)
            if ( !Object.keys(reviewCountByMonth).includes(year) ) {
                reviewCountByMonth[year] = {}
            }
            if ( !Object.keys(reviewCountByMonth[year]).includes(month) ) {
                reviewCountByMonth[year][month] = 0
            }
            reviewCountByMonth[year][month] += 1
        })
        return reviewCountByMonth;
    },
 
    getReviewCountByReviewer() {
        // Define data object for counting reviews
        const reviewCountByReviewer = {}
 
        // Loop through reviews to count for each score
        reviewStore.reviews.forEach((review)=> {
            // Define reviewerID variable from reviewerID property of review
            const { reviewerID } = review
 
            // Check for existing key for this reviewerID
            if ( !Object.keys(reviewCountByReviewer).includes(reviewerID) ) {
                // If none exists, create new key with count of 0
                reviewCountByReviewer[reviewerID] = 0
            }
 
            // Add one to the review count for this reviewerID
            reviewCountByReviewer[reviewerID] += 1
        })
 
        // Return data object with review counts
        return reviewCountByReviewer;
    },
 
    getReviewCountByScore() {
        const reviewCountByScore = {}
        reviewStore.reviews.forEach((review)=> {
            const score = review.overall.toString()
            if ( !Object.keys(reviewCountByScore).includes(score) ) {
                reviewCountByScore[score] = 0
            }
            reviewCountByScore[score] += 1
        })
        return reviewCountByScore;
    }
})
 
export default reviewStore