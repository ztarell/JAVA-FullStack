$(document).ready(function () {
    loadDvds();


    $('#create-dvd-button').click(function (event) {
        $('#contactTableDiv').hide();
        $('#homepage').hide();
        $('#addDvdForm').show();
    });

    $('#cancel-button').click(function (event) {
        $('#add-dvd-title').val('');
        $('#add-release-year').val('');
        $('#add-director').val('');
        $('#add-rating').val('');
        $('#add-notes').val('');
        $('#addDvdForm').hide();
        $('#contactTableDiv').show();
        $('#homepage').show();

    });

    $('#cancel-edit-button').click(function (event) {
        $('#edit-dvd-title').val('');
        $('#edit-release-year').val('');
        $('#edit-director').val('');
        $('#edit-rating').val('');
        $('#edit-notes').val('');
        $('#editDvdForm').hide();
        $('#contactTableDiv').show();
        $('#homepage').show();

    });

    $('#submit-dvd-button').click(function (event) {
        var haveValidationErrors = checkAndDisplayValidationErrors($('#addDvdForm').find('input'));

        if (haveValidationErrors) {
            return false;
        }


        $.ajax({
            type: 'POST',
            url: 'https://tsg-dvds.herokuapp.com/dvd',
            data: JSON.stringify({
                title: $('#add-dvd-title').val(),
                releaseYear: $('#add-release-year').val(),
                director: $('#add-director').val(),
                rating: $('#add-rating').val(),
                notes: $('#add-notes').val()
            }),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            'dataType': 'json',
            success: function () {
                $('#errorMessages').empty();
                $('#add-dvd-title').val('');
                $('#add-release-year').val('');
                $('#add-director').val('');
                $('#add-rating').val('');
                $('#add-notes').val('');
                $('#addDvdForm').hide();
                $('#contactTableDiv').show();
                $('#homepage').show();
                clearDvdTable();
                loadDvds();

            },
            error: function () {
                $('#errorMessages')
                    .append($('<li>')
                        .attr({
                            class: 'list-group-item list-group-item-danger'
                        })
                        .text('Error calling web service. Please try again later.'));
            }
        })

    });

    $('#edit-dvd-button').click(function (event) {
        var haveValidationErrors = checkAndDisplayValidationErrors($('#editDvdForm').find('input'));

        if (haveValidationErrors) {
            return false;
        }




        $.ajax({
            type: 'PUT',
            url: 'https://tsg-dvds.herokuapp.com/dvd/' + $('#edit-dvdId').val(),
            data: JSON.stringify({
                id: $('#edit-dvdId').val(),
                title: $('#edit-dvd-title').val(),
                releaseYear: $('#edit-release-year').val(),
                director: $('#edit-director').val(),
                rating: $('#edit-rating').val(),
                notes: $('#edit-notes').val()
            }),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            'dataType': 'json',
            success: function () {
                $('#errorMessages').empty();
                $('#edit-dvd-title').val('');
                $('#edit-release-year').val('');
                $('#edit-director').val('');
                $('#edit-rating').val('');
                $('#edit-notes').val('');
                $('#editDvdForm').hide();
                $('#contactTableDiv').show();
                $('#homepage').show();
                clearDvdTable();
                loadDvds();

            },
            error: function () {
                $('#errorMessagesEdit')
                    .append($('<li>')
                        .attr({
                            class: 'list-group-item list-group-item-danger'
                        })
                        .text('Error calling web service. Please try again later.'));
            }
        })

    });

    $("#search-button").click(function (event) {
        clearDvdTable();
        var contentRows = $('#contentRows');

        $.ajax({
            type: 'GET',
            url: 'https://tsg-dvds.herokuapp.com/dvds/' + $('#search-category').val() + '/' + $('#search-text').val(),
            success: function (data, status) {
                $.each(data, function (index, dvd) {
                    var name = dvd.title;
                    var date = dvd.releaseYear;
                    var dir = dvd.director;
                    var rate = dvd.rating;
                    var dvdId = dvd.id;

                    var row = '<tr>';
                    row += '<td>' + name + '</td>';
                    row += '<td>' + date + '</td>';
                    row += '<td>' + dir + '</td>';
                    row += '<td>' + rate + '</td>';
                    row += '<td><a onclick="editDvd(' + dvdId + ')">Edit</a> | <a onclick="deleteConfirmation(' + dvdId + ')">Delete</a></td>';
                    row += '</tr>';

                    contentRows.append(row);
                })
            },
            error: function () {
                $('#errorMessages')
                    .append($('<li>')
                        .attr({
                            class: 'list-group-item list-group-item-danger'
                        })
                        .text('Error calling web service. Please try again later.'));
            }
        })
    });


});



function loadDvds() {
    clearDvdTable();
    var contentRows = $('#contentRows');

    $.ajax({
        type: 'GET',
        url: 'https://tsg-dvds.herokuapp.com/dvds/',
        success: function (data, status) {
            $.each(data, function (index, dvd) {
                var name = dvd.title;
                var date = dvd.releaseYear;
                var dir = dvd.director;
                var rate = dvd.rating;
                var dvdId = dvd.id;

                var row = '<tr>';
                row += '<td><a onclick="showDvd(' + dvdId + ')">' + name + '</a></td>';
                row += '<td>' + date + '</td>';
                row += '<td>' + dir + '</td>';
                row += '<td>' + rate + '</td>';
                row += '<td><a onclick="editDvd(' + dvdId + ')">Edit</a> | <a onclick="deleteConfirmation(' + dvdId + ')">Delete</a></td>';
                row += '</tr>';

                contentRows.append(row);
            })
        },
        error: function () {
            $('#errorMessages')
                .append($('<li>')
                    .attr({
                        class: 'list-group-item list-group-item-danger'
                    })
                    .text('Error calling web service. Please try again later.'));
        }
    });
}



function clearDvdTable() {
    $('#contentRows').empty();
}


function deleteConfirmation(dvdId) {
    if (confirm("Are you sure you want to delete this DVD from your colection?") == true) {
        deleteDvd(dvdId);
    } else {
        loadDvds();
    }
}

function deleteDvd(dvdId) {
    $.ajax({
        type: 'DELETE',
        url: 'https://tsg-dvds.herokuapp.com/dvd/' + dvdId,
        success: function () {
            loadDvds();
        }
    });
}

function editDvd(dvdId) {

    $.ajax({
        type: 'GET',
        url: 'https://tsg-dvds.herokuapp.com/dvd/' + dvdId,
        success: function (data, status) {
            $('#edit-dvd-title').val(data.title);
            $('#edit-release-year').val(data.releaseYear);
            $('#edit-director').val(data.director);
            $('#edit-rating').val(data.rating);
            $('#edit-notes').val(data.notes);
            $('#edit-dvdId').val(data.dvdId);
        },
        error: function () {
            $('#errorMessages')
                .append($('<li>')
                    .attr({
                        class: 'list-group-item list-group-item-danger'
                    })
                    .text('Error calling web service. Please try again later.'));
        }
    })
    $('#contactTableDiv').hide();
    $('#homepage').hide();
    $('#editDvdForm').show();

}


function showDvd(dvdId) {
    $('#contactTableDiv').hide();
    $('#homepage').hide();
    $('#dvdInformation').show();


    $.ajax({
        type: 'GET',
        url: 'https://tsg-dvds.herokuapp.com/dvds/' + dvdId,
        success: function (data, status) {
            $('.dvdTitle').html(data.title);
            $('.dvdYear .year').html(data.releaseYear);
            $('.dvdDirector .director').html(data.director);
            $('.dvdRating .rating').html(data.rating);
            $('.dvdNotes .notes').html(data.notes);

        },
        error: function () {
            $('#errorMessages')
                .append($('<li>')
                    .attr({
                        class: 'list-group-item list-group-item-danger'
                    })
                    .text('Error calling web service. Please try again later.'));
        }
    })

}

function hideShowDvd() {
    $('#dvdInformation').hide();
    $('#contactTableDiv').show();
    $('#homepage').show();
}

function checkAndDisplayValidationErrors(input) {

    $('#errorMessages').empty();
    $('#errorMessagesEdit').empty();

    var errorMessages = [];


    input.each(function () {

        if (!this.validity.valid) {
            var errorField = $('label[for=' + this.id + ']').text();
            errorMessages.push(errorField + ' ' + this.validationMessage);
        }
    });


    if (errorMessages.length > 0) {
        $.each(errorMessages, function (index, message) {
            $('#errorMessages').append($('<li>').attr({
                class: 'list-group-item list-group-item-danger'
            }).text(message));
            $('#errorMessagesEdit').append($('<li>').attr({
                class: 'list-group-item list-group-item-danger'
            }).text(message));
        });
        return true;
    } else {
        return false;
    }
}