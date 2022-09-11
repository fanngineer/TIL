let q = 0;
let idx = 0;
const URLSearch = new URLSearchParams(location.search);
const iframe = document.getElementById("iframe");
q = URLSearch.get("q");
idx = URLSearch.get("idx");
// axios.get("data/video.json").then(response => {return response.data}).then(data => {iframe.src = data[q].url})
let reviews = [];
let reviewsGet = JSON.parse(localStorage.getItem(q));
if(reviewsGet){
  reviewsGet.forEach(el => {reviews.push(el)});
}
let review = reviews[idx];
reviews[idx].views++;
localStorage.setItem(q,JSON.stringify(reviews))
document.querySelector("article").innerHTML = 
`
<p>${review.title}</p>
    <span>작성일 : ${review.date}</span>
    <span>조회수 : ${review.views}</span>
    <hr>
    <p>${review.content}</p>
`

//목록 버튼
document.querySelector("#bt-li").addEventListener("click",event => {
 
  window.location = `/review_list.html?q=${q}`

});
//수정 버튼
document.querySelector("#bt-re").addEventListener("click",event => {
 
  window.location = `/review_revise.html?q=${q}&idx=${idx}`

});
//삭제 버튼
document.querySelector("#bt-de").addEventListener("click",event => {
 
  reviews.splice(idx,1);
  localStorage.setItem(q,JSON.stringify(reviews));
  window.location = `/review_list.html?q=${q}`;
});