import React, { Component } from 'react'
import { BarChart } from 'react-d3-components'
import * as queryString from 'query-string';
 
import { view } from '@risingstack/react-easy-state'
import reviewStore from '../stores/review_store'
 
var data = {
    label: 'Review Count by Reviewer (Demo)',
    values: [
        {"x": "A2IBPI20UZIR0U", "y": 150 },
        {"x": "A14VAT5EAX3D9S", "y": 120},
        {"x": "A195EZSQDW3E21", "y": 80},
        {"x": "A2C00NNG1ZQQG2", "y": 77},
        {"x": "A94QU4C90B1AX", "y": 70},
        {"x": "A2A039TZMZHH9Y", "y": 53},
        {"x": "A1UPZM995ZAH90", "y": 25},
        {"x": "AJNFQI3YR6XJ5", "y": 24},
        {"x": "A3M1PLEYNDEYO8", "y": 23},
        {"x": "AMNTZU1YQN1TH", "y": 23}
    ]
};
 
var sort = null; // d3.ascending, d3.descending, func(a,b) { return a - b; }, etc...
 
class ReviewsBarChart extends Component {
    state = { data: data }
 
    componentDidMount() {
        // Update component state when it mounts to use review data
        if ( reviewStore.reviews.length > 0 ) {
            const barChartData = this.getBarChartData()
            this.setState({ data: barChartData })
       }
    }
 
    // Formatraw review count data for the bar chart
    getBarChartData() {
        // Parse queryParams from props.location.search using query-string
        // Use ignoreQueryPrefix set to true to ignore leading '?'
        const queryParams = queryString.parse(this.props.location.search, { ignoreQueryPrefix: true })
 
        // Create data objects for allValues and barChartData
        // Label and values to be determined based on queryParams
        const barChartData = { label: '', values: [] }
        const allValues = []
 
        // Get values based on reviewer when set to group_by reviewer
        if ( queryParams.group_by === 'reviewer' ) {
            barChartData.label = 'Review Count by Reviewer (from JSON)'
            const reviewCountByReviewer = reviewStore.getReviewCountByReviewer()
 
            // Loop through all reviewerIDs and create values objects
            Object.keys(reviewCountByReviewer).sort().forEach((reviewerID) => {
                // Y value: Count calculated in store
                const yValue = reviewCountByReviewer[reviewerID]
 
                // Add data values formatted for line chart
                allValues.push({x: reviewerID, y: yValue})
            })
        }
 
        // Sort reviewer counts by most reviews and keep the top values up to numValues
        const numValues = 10
        barChartData.values = allValues
            .sort((a, b) => (b.y > a.y) ? 1 : -1)
            .slice(0, numValues)
 
        return barChartData
    }
 
 
    render(){
        const { data } = this.state
        return (
            <div>
                <h2>{data.label}</h2>
                <BarChart
                    data={data}
                    width={800}
                    height={400}
                    margin={{top: 50, bottom: 50, left: 100, right: 100}}
                    sort={sort}
                />
                <style>{`
                g.x.axis text {
                    font-size: 10px;
                    transform-origin: 25px 50px;
                    transform: rotate(-25deg);
                }
                `}</style>
            </div>
        )
    }
}
 
export default view(ReviewsBarChart)
