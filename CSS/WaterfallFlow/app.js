window.onload = function () {
    imgLocation('container', 'box');

    var imgData = {"data":[{"src":"2.jpg"},{"src":"3.jpg"},{"src":"4.jpg"},{"src":"5.jpg"},{"src":"6.jpg"}]};

    window.onscroll = function(){
        if (checkFlag()){
            var cparent = document.getElementById('container');
            for (var i=0;i<imgData.data.length;i++){
                var box = document.createElement('div');
                box.className = 'box';
                cparent.appendChild(box);
                var box_img = document.createElement('div');
                box_img.className = 'box_img';
                box.appendChild(box_img);
                var img = document.createElement('img');
                img.src = 'images/' + imgData.data[i].src;
                box_img.appendChild(img);
            }
            imgLocation('container', 'box');
        }
    }
}


function checkFlag(){
    var cparent = document.getElementById('container');
    var ccontent = getChildElement(cparent, 'box');
    var lastContentHeight = ccontent[ccontent.length - 1].offsetTop;
    var scrollTop = document.documentElement.scrollTop || document.body.scrollTop;
    var pageHeight = document.documentElement.clientHeight || document.body.clientHeight;

    console.log(pageHeight + ' : ' + scrollTop + ' : ' + lastContentHeight);

    if (lastContentHeight < pageHeight + scrollTop){
        return true;
    }
}

function imgLocation(parent, content){
    cparent = document.getElementById(parent);
    ccontent = getChildElement(cparent, content);

    var imgWidth = ccontent[0].offsetWidth;
    //console.log(imgWidth);
    var cols = Math.floor(document.documentElement.clientWidth / imgWidth);
    //console.log(cols);
    cparent.style.cssText = "width:" + imgWidth * cols + "px; margin: 0px auto;";

    //console.log(ccontent.length);

    var BoxHeightArr = [];
    for (var i=0;i<ccontent.length;i++){
        if (i<cols) {
            BoxHeightArr[i] = ccontent[i].offsetHeight;
            //console.log(BoxHeightArr[i]);
        }else{
            minheight = Math.min.apply(null, BoxHeightArr);
            //console.log(minheight);

            var minIndex = getminheightIndex(BoxHeightArr, minheight);

            ccontent[i].style.position = 'absolute';
            ccontent[i].style.top = minheight + 'px';
            ccontent[i].style.left = ccontent[minIndex].offsetLeft + 'px';

            BoxHeightArr[minIndex] += ccontent[i].offsetHeight;
        }
    }
}

function getminheightIndex(BoxHeightArr, minheight){
    for (var i=0;i<BoxHeightArr.length;i++){
        if (BoxHeightArr[i] == minheight){
            return i;
        }
    }
}

function getChildElement(parent, content){
    var contentarr = [];
    var allcontent = parent.getElementsByTagName('*');
    for (var i=0;i<allcontent.length;i++){
        if (allcontent[i].className == content){
            contentarr.push(allcontent[i]);
        }
    }
    return contentarr;
}