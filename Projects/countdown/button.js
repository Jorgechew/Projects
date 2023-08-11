
window.onload = function() {

const horas = document.getElementById('horas');
const minutos = document.getElementById('minutos');
const segundos = document.getElementById('segundos');
const days = document.getElementById('days');

const relogio = setInterval(function time() {

    var countDownDate = new Date("Out 16, 2024 16:00:00").getTime();

    let dataToday = new Date().getTime();

    var distance = countDownDate - dataToday;

    days.textContent = day;
    horas.textContent = hr;
    minutos.textContent = min;
    segundos.textContent = seg;
    

    let hr = Math.floor((distance % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
    let min = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
    let seg = Math.floor((distance % (1000 * 60)) / 1000);
    let day = Math.floor(distance / (1000 * 60 * 60 * 24));
 

   if (distance < 0) {
    clearInterval(x);
    document.getElementById("demo").innerHTML = "EXPIRED";
  }
        }, 1000);

}
 
    
    
    

