let q = 0;
const URLSearch = new URLSearchParams(location.search);
q = URLSearch.get("q");
// axios.get("data/video.json").then(response => {return response.data}).then(data => {})
const title = document.getElementById("title");
const content = document.getElementById("content");

const bt_regist = document.getElementById("bt_regist");
bt_regist.addEventListener("click",event => {
  let reviews = [];
  let reviewsStr = localStorage.getItem(q);
  if(reviewsStr){
    JSON.parse(reviewsStr).forEach(ele => {reviews.push(ele)});
  }
  let date = new Date().toLocaleString('ko-kr');
  let temp = {"title":title.value,"content":content.value,"date":date,"views":0};
  reviews.push(temp);

  localStorage.setItem(q,JSON.stringify(reviews));
  window.location = `/review_list.html?q=${q}`

});
document.getElementById("bt_cancel").addEventListener("click",event => {
 
  window.location = `/review_list.html?q=${q}`

});
