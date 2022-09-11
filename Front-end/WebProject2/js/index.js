const trendingVideoBox = document.getElementById("trending-video-box");
const partVideoBox = document.getElementById("part-video-box");
const selectPart = document.getElementById("select-part");
const partBtns = selectPart.querySelectorAll("button");

const parts = {"전신":0,"상체":1,"하체":2,"복부":3};
let trendStartIdx = 0;
let trendEndIdx = 3;

let partNow = 0;

function trendingVideo(startIdx, endIdx){
    axios.get("data/video.json").then((response) => {
        return response.data;
    }).then((res)=>{
        trendingVideoBox.innerHTML = "";
        for(let i = startIdx;i<endIdx;i++){
            let data = res[i];
            let tempHtml = document.createElement("div");
            tempHtml.className = "video-card";
            tempHtml.innerHTML = `
                <div class="video-card-img-box">
                    <iframe src="${data.url}" frameborder="0"></iframe>
                </div>
                <div class="video-card-desc">
                    <div class="video-card-title"><p><a href="/review_list.html?q=${i}">${data.title}</a></p></div>
                    <div class="video-card-part-channel"><button type="button" class="btn btn-outline-success btn-sm">${data.part}</button> <span>${data.channelName}</span></div>
                </div>
            `
            trendingVideoBox.append(tempHtml);
            
        }
    })
}

partBtns.forEach(btn => {
    btn.addEventListener("click", (event)=>{
        axios.get("data/video.json").then((response) => {
            return response.data.filter(ele => ele.part===btn.value);
        }).then((res)=>{
            partVideoBox.innerHTML = ``;
            for(let i = 0;i<3;i++){
                let data = res[i];
                let tempHtml = document.createElement("div");
                tempHtml.className = "video-card";
                tempHtml.innerHTML = `
                    <div class="video-card-img-box">
                        <iframe src="${data.url}" frameborder="0"></iframe>
                    </div>
                    <div class="video-card-desc">
                        <div class="video-card-title"><a href="/review_list.html?q=${i}">${data.title}</a></div>
                        <div class="video-card-part-channel"><button type="button" class="btn btn-outline-success btn-sm">${data.part}</button> <span>${data.channelName}</span></div>
                    </div>
                `
                partVideoBox.append(tempHtml);
                
            }
        })
        partNow = parts[btn.value];
    })
})


trendingVideo(trendStartIdx,trendEndIdx);
partBtns[0].click();

document.getElementById("partPrev").addEventListener("click", (event)=>{
    partBtns[(partNow + 3)%4].click();
})
document.getElementById("partNext").addEventListener("click", (event)=>{
    partBtns[(partNow + 1)%4].click();
})

document.getElementById("trendPrev").addEventListener("click", (event)=>{
    if(trendStartIdx > 3){
        trendStartIdx -= 3;
        trendEndIdx -= 3;
    } else if(trendStartIdx === 0) {
        trendStartIdx = 5;
        trendEndIdx = 8;
    } else {
        trendStartIdx = 0;
        trendEndIdx = 3;
    }
    trendingVideo(trendStartIdx,trendEndIdx);
})

document.getElementById("trendNext").addEventListener("click", (event)=>{
    if(trendEndIdx < 5){
        trendStartIdx += 3;
        trendEndIdx += 3;
    } else if(trendEndIdx === 8) {
        trendStartIdx = 0;
        trendEndIdx = 3;
    } else {
        trendStartIdx = 5;
        trendEndIdx = 8;
    }
    trendingVideo(trendStartIdx,trendEndIdx);
})