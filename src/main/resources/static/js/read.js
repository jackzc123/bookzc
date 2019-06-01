/* 书架 */
function LastRead(){this.bookList="bookList"}
LastRead.prototype={
    set:function(bid,tid,title,texttitle,author,sortname,rid){
        if(!(bid&&tid&&title&&texttitle&&author&&sortname))return;
        var v=bid+'#'+tid+'#'+title+'#'+texttitle+'#'+author+'#'+sortname+'#'+rid;
        this.setItem(bid,v);
        this.setBook(bid)
    },
    get:function(k){
        return this.getItem(k)?this.getItem(k).split("#"):"";
    },
    remove:function(k){
        this.removeItem(k);
        this.removeBook(k)
    },
    setBook:function(v){
        var reg=new RegExp("(^|#)"+v);
        var books =	this.getItem(this.bookList);
        if(books==""){
            books=v
        }
        else{
            if(books.search(reg)==-1){
                books+="#"+v
            }
            else{
                books.replace(reg,"#"+v)
            }
        }
        this.setItem(this.bookList,books)
    },
    getBook:function(){
        var v=this.getItem(this.bookList)?this.getItem(this.bookList).split("#"):Array();
        var books=Array();
        if(v.length){
            for(var i=0;i<v.length;i++){
                var tem=this.getItem(v[i]).split('#');
                if (tem.length>3)books.push(tem);
            }
        }
        return books
    },
    removeBook:function(v){
        var reg=new RegExp("(^|#)"+v);
        var books=this.getItem(this.bookList);
        if(!books){
            books=""
        }
        else{
            if(books.search(reg)!=-1){
                books=books.replace(reg,"")
            }
        }
        this.setItem(this.bookList,books)
    },
    setItem:function(k,v){
        if(!!window.localStorage){
            localStorage.setItem(k,v);
        }
        else{
            var expireDate=new Date();
            var EXPIR_MONTH=30*24*3600*1000;
            expireDate.setTime(expireDate.getTime()+12*EXPIR_MONTH)
            document.cookie=k+"="+encodeURIComponent(v)+";expires="+expireDate.toGMTString()+"; path=/";
        }
    },
    getItem:function(k){
        var value=""
        var result=""
        if(!!window.localStorage){
            result=window.localStorage.getItem(k);
            value=result||"";
        }
        else{
            var reg=new RegExp("(^| )"+k+"=([^;]*)(;|\x24)");
            var result=reg.exec(document.cookie);
            if(result){
                value=decodeURIComponent(result[2])||""}
        }
        return value
    },
    removeItem:function(k){
        if(!!window.localStorage){
            window.localStorage.removeItem(k);
        }
        else{
            var expireDate=new Date();
            expireDate.setTime(expireDate.getTime()-1000)
            document.cookie=k+"= "+";expires="+expireDate.toGMTString()
        }
    },
    removeAll:function(){
        if(!!window.localStorage){
            window.localStorage.clear();
        }
        else{
            var v=this.getItem(this.bookList)?this.getItem(this.bookList).split("#"):Array();
            var books=Array();
            if(v.length){
                for( i in v ){
                    var tem=this.removeItem(v[k])
                }
            }
            this.removeItem(this.bookList)
        }
    }
}
window.lastread = new LastRead();





function loadbooker()
{
    var bookhtml='';
    var books=lastread.getBook();
    var books=books.reverse();
    if(books.length){
        for(var i=0 ;i<books.length;i++){
            if(i<=19){
                bookhtml+='<div class="bookcase-book"><div class="book-img"><a href="/read/'+books[i][0]+'/"><img src="/files/'+Math.floor(books[i][0]/1000)+'/'+books[i][0]+'/'+books[i][0]+'.jpg" onerror="this.src=\'/images/nocover.jpg\'"></a></div><div class="book-info"><h4><a href="/read/'+books[i][0]+'/">'+books[i][2]+'</a></h4><p class="classify">分类：'+booktype[books[i][5]]["caption"]+'</p><p class="author">作者：'+books[i][4]+'</p><p class="read"><span>已读到：</span><a href="chapter.html?1#mybookid='+books[i][0]+'&bookid='+books[i][6]+'&chapterid='+books[i][1]+'">'+books[i][3]+'</a></p></div><div class="del-btn"><a class="border-btn" href="javascript:removebook(\''+books[i][0]+'\')">删除</a></div></div>'
            }
        }
    }
    else{
        bookhtml+='<div style="height:100px;line-height:100px; text-align:center">还木有任何书籍( ˙﹏˙ )</div>';
    }
    $(".read_book").html(bookhtml);
}
function removebook(k){lastread.remove(k);loadbooker();}

/*临时书架 end*/

booktype=new Array();
booktype[1] = { 'caption' : '玄幻小说', 'shortname' : '玄幻'};
booktype[2] = { 'caption' : '修真小说', 'shortname' : '修真'};
booktype[3] = { 'caption' : '都市小说', 'shortname' : '都市'};
booktype[4] = { 'caption' : '历史小说', 'shortname' : '历史'};
booktype[5] = { 'caption' : '网游小说', 'shortname' : '网游'};
booktype[6] = { 'caption' : '科幻小说', 'shortname' : '科幻'};
booktype[7] = { 'caption' : '女生小说', 'shortname' : '女生'};
booktype[8] = { 'caption' : 'N次元', 'shortname' : 'N次元'};
booktype[9] = { 'caption' : '其他小说', 'shortname' : '其他'};
booktype[10] = { 'caption' : '主角小说', 'shortname' : '主角'};

function tongji(){
    var _hmt = _hmt || [];
    (function() {
        var hm = document.createElement("script");
        hm.src = "https://hm.baidu.com/hm.js?92aba3e4f105050c3554fc4ac3120577";
        var s = document.getElementsByTagName("script")[0];
        s.parentNode.insertBefore(hm, s);
    })();
}

function tongji2(){
    var _hmt = _hmt || [];
    (function() {
        var hm = document.createElement("script");
        hm.src = "https://hm.baidu.com/hm.js?a197273f4aa1687909ca5973b95ca724";
        var s = document.getElementsByTagName("script")[0];
        s.parentNode.insertBefore(hm, s);
    })();
}