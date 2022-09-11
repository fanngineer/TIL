let q = 0;
const URLSearch = new URLSearchParams(location.search);
const iframe = document.getElementById("iframe");
q = URLSearch.get("q");
axios.get("data/video.json").then(response => {return response.data}).then(data => {iframe.src = data[q].url})
let reviews = [];
let reviewsGet = JSON.parse(localStorage.getItem(q));
if(reviewsGet){
  reviewsGet.forEach(el => {reviews.push(el)});
}
let num = 0;
const tbody = document.getElementById("reviewList");
reviews.forEach(element => {
  num++;
  let review = document.createElement("tr");
  review.innerHTML = `
  <th>${num}</th>
  <td class = "title" id="${num-1}">${element.title}</td>
  <td>${element.views}</td>
  <td>${element.date}</td>
  `
  tbody.append(review);
});
//글작성
const regist = document.getElementById("regist");
regist.addEventListener("click",event => {
  
  window.location = `/review_regist.html?q=${q}`

});

document.querySelectorAll(".title").forEach(el => el.addEventListener("click",event => {
 
  window.location = `/review_detail.html?q=${q}&idx=${el.id}`

}));