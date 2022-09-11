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
const title = document.getElementById("title");
const content = document.getElementById("content");
title.value = review.title;
content.value = review.content;


//수정 버튼
document.querySelector("#bt_regist").addEventListener("click",event => {
 
  let date = new Date().toLocaleString('ko-kr');
  let temp = {"title":title.value,"content":content.value,"date":date,"views":review.views};
  reviews[idx] = temp;

  localStorage.setItem(q,JSON.stringify(reviews));
  window.location = `/review_list.html?q=${q}`

});
//취소 버튼
document.querySelector("#bt_cancel").addEventListener("click",event => {
 
  window.location = `/review_list.html?q=${q}`;
});