// Fetch the list of novels from the API


const options = {
	method: 'GET',
	headers: {
		'X-RapidAPI-Key': 'a6a527b28emshdbd386cbee5f46dp13349ejsncf46886ef8a0',
		'X-RapidAPI-Host': 'web-novel-api.p.rapidapi.com'
	}
};

// 	Api using JQuery

// const settings = {
// 	"async": true,
// 	"crossDomain": true,
// 	"url": "https://web-novel-api.p.rapidapi.com/genres",
// 	"method": "GET",
// 	"headers": {
// 		"X-RapidAPI-Key": "a6a527b28emshdbd386cbee5f46dp13349ejsncf46886ef8a0",
// 		"X-RapidAPI-Host": "web-novel-api.p.rapidapi.com"
// 	}
// };
//
// $.ajax(settings).done(function (response) {
// 	console.log(response);
// });



// 	Api using fetch

fetch('https://web-novel-api.p.rapidapi.com/genres', options)
	.then(response => response.json())
	  .then(data => {
    // Get the div element where the list of novels will be displayed
    const novelList = document.getElementById('novel-list');

    // Iterate through the list of novels and create a new div element for each one

          // Create a new div element for each novel
          for (let i = 0; i < data.length; i++) {
            const novelDiv = document.createElement('div');
            novelDiv.innerHTML = data[i].title;
            novelDiv.classList.add("novel-card");
           novelList.appendChild(novelDiv);
          }
        });
//	.then(response => console.log(response))
//	.catch(err => console.error(err));


//	Api using Axios

// import axios from "axios";

// const options = {
// 	method: 'GET',
// 	url: 'https://web-novel-api.p.rapidapi.com/genres',
// 	headers: {
// 		'X-RapidAPI-Key': 'a6a527b28emshdbd386cbee5f46dp13349ejsncf46886ef8a0',
// 		'X-RapidAPI-Host': 'web-novel-api.p.rapidapi.com'
// 	}
// };
//
// axios.request(options).then(function (response) {
// 	console.log(response.data);
// }).catch(function (error) {
// 	console.error(error);
// });

 




