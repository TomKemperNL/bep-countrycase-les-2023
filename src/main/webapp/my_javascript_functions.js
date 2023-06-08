let btn = document.querySelector('#send');

btn.addEventListener('click', function(){
    let getal1 = parseInt(document.forms['myform'].getal1.value);
    let getal2 = parseInt(document.forms['myform'].getal2.value);

    fetch('/restservices/calculator/telop', {
        method: 'POST',
        headers: {
            'Content-Type':'application/json'
        },
        body: JSON.stringify({
            getal1: getal1,
            getal2: getal2
        })
    }).then(r => {
        if(r.ok){
            return r.json();
        }else{
            throw new Error("Ongeldige aanroep");
        }
    }).then(resultaatObj => {
        console.log(resultaatObj.resultaat);

        let resultLabel = document.querySelector('#result');
        resultLabel.innerHTML = resultaatObj.resultaat;
    });

});