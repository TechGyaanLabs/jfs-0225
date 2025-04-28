api_key = 'b968754c2b9a45d4bc54f5793806f40a'


const idCountry = document.getElementById('country');
const idCategory = document.getElementById('category');

idCategory.addEventListener('change', function() {
    const selectedCategory = idCategory.value;
    const selectedCountry = idCountry.value;

    if (selectedCategory && selectedCountry) {
        fetchNews(selectedCategory, selectedCountry);
    }
}
);
idCountry.addEventListener('change', function() {
    const selectedCategory = idCategory.value;
    const selectedCountry = idCountry.value;

    if (selectedCategory && selectedCountry) {
        fetchNews(selectedCategory, selectedCountry);
    }
}
);

function fetchNews(category, country) {
    
    const url = `https://newsapi.org/v2/top-headlines?category=${category}&country=${country}&apiKey=${api_key}`;
    fetch(url)
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json();
        })
        .then(data => {
            displayNews(data.articles);
        })
        .catch(error => {
            console.error('There was a problem with the fetch operation:', error);
        });
}

function displayNews(articles) {
   const idNewsContent = document.getElementById('newsContent');
    idNewsContent.innerHTML = ''; // Clear previous content

    if(articles.length === 0) {
        idNewsContent.innerHTML = '<p>No news articles found.</p>';
        return;
    }
    let articlesData = '';
    articles.forEach(article => {
       articlesData += `
       <div class="card mt-5 mb-3">
        <img class="card-img-top" src=${article['urlToImage']} alt="Card image cap">
        <div class="card-body">
            <h5 class="card-title">${article['title']}</h5>
            <p class="card-text">${article['description']}</p>
            <a href='${article['url']}' class="btn btn-primary">Go somewhere</a>
        </div>
        </div>`
       
    });
    idNewsContent.innerHTML = articlesData;
}

const changeEvent = new Event('change');
idCountry.dispatchEvent(changeEvent);
