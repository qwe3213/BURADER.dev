 document.addEventListener('DOMContentLoaded', function() {
  var calendarEl = document.getElementById('calendar');

  var calendar = new FullCalendar.Calendar(calendarEl, {

    googleCalendarApiKey: 'AIzaSyAfjV43c6cm20m9ttstcyJrYvVDhoHeVqs',
	    titleFormat: function (date) {
	        // YYYY년 MM월
	        return `${date.date.year}년 ${date.date.month + 1}월`;
	      },

    	dayMaxEventRows: true, // 모든 뷰에서 이벤트의 최대 행 수를 설정
    	views: {
    	timeGrid: {
    	dayMaxEventRows: 3 // adjust to 6 only for timeGridWeek/timeGridDay
    	}
    	},
    
    headerToolbar: {
        left: 'prev',
        center: 'title',
        right: 'next'
      },
    eventSources: [
    {
          googleCalendarId: 'e53edbf90f8b1b8a49ec273c8fef962ca5763b374fddc15c4194c84ae18e772d@group.calendar.google.com',
          className: 'Alcoholic',
          color: '#8BC34A'
        	  //#33c92d, #181824, #1e7a81
        },
     {
        	 googleCalendarId : "ko.south_korea#holiday@group.v.calendar.google.com", 
             className : "대한민국의 휴일", 
             color : '#F4797E'
     	},

    ]
  });
  calendar.render();
});
 
 