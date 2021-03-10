$(document).ready(function () {
  $("h1").addClass("text-center");
  $("h2").addClass("text-center");
  $(".myBannerHeading").addClass(".page-header");
  $("#yellowHeading").text("Yellow Team");
  $('#orangeTeamList').css({'background-color': 'Orange'});
  $('#blueTeamList').css({'background-color': 'blue'});
  $('#redTeamList').css({'background-color': 'Red'});
  $('#yellowTeamList').css({'background-color': 'Yellow'});
  $('#yellowTeamList').append('<li>Joseph Banks</li>', '<li>Simon Jones</li>');
  $(".row .col-md-12#oops").hide("HIDE ME!!!");
  $('h2#footerPlaceholder').remove();
  $('.footer#footer').append('<p>Zach Tarell   zach.tarell@gmail.com</p>');
  $('.footer#footer').css({'font-family': 'Courier', 'font-size': '24px'});
});
