console.log('bla')
let olletje = document.querySelector('#countries');

function refresh() {
    olletje.innerHTML = '';
    fetch('http://localhost:8080/restservices/countries')
        .then(response => {
            return response.json();
        })
        .then(countries => {
            for (let c of countries) {
                let nieuweLi = document.createElement('li');

                nieuweLi.innerHTML = `<a href="http://localhost:8080/restservices/countries/${c.code}">${c.name}</a>`
                olletje.appendChild(nieuweLi);

            }
        });
}

let newButton = document.querySelector('#newButton');
let naamVeld = document.querySelector('#naam');
let codeVeld = document.querySelector('#code');
let iso3Veld = document.querySelector('#iso3');

function opdeknopdrukken() {
    console.log(arguments)
    nieuwCountry(naamVeld.value, codeVeld.value, iso3Veld.value)
}

function nieuwCountry(naam, codeVeld, iso3Veld) {
    fetch('http://localhost:8080/restservices/countries',
        {
            method: 'POST',
            body: JSON.stringify({
                name: naam,
                code: codeVeld,
                iso3: iso3Veld
            }),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(refresh);


}

newButton.addEventListener('click', opdeknopdrukken);


refresh();