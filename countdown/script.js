
window.onload = function() {

const hoursEl = document.getElementById('hours');
const minutesEl = document.getElementById('minutes');
const secondsEl = document.getElementById('seconds');
const daysEl = document.getElementById('days');

const countDownDate = "8 Sept 2023 09:31:00";

 function countdown(){

    const newDate = new Date(countDownDate);
    const dataToday = new Date();


    const totalSeconds = (newDate - dataToday) / 1000;
    

    const days = Math.floor(totalSeconds / 3600 / 24);
    const hours = Math.floor(totalSeconds / 3600) % 24;
    const minutes = Math.floor(totalSeconds / 60) % 60;
    const seconds = Math.floor(totalSeconds) % 60;
 
    daysEl.innerHTML = days;
    hoursEl.innerHTML = formatTime(hours);
    minutesEl.innerHTML = formatTime(minutes);
    secondsEl.innerHTML = formatTime(seconds);
};

function formatTime(time){
  return time < 10 ? `0${time}` : time;
}


countdown();

setInterval(countdown, 1000);
}