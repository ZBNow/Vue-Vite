import Mock from 'mockjs'
import * as Login from "./mockLogin.js"
import * as Think from "./mockThink.js"

Mock.setup({
    timeout:500
})

//Mock.mock(/\/login/,'post',(opt)=>Login.postlogin(opt));

/*Mock.mock(/\/login/,'get',(opt)=>{
    return Login.loginget(opt);
});*/

Mock.mock(/\/register/,'post',(opt)=>{
    Login.register(opt);
});

//Mock.mock(/\/thinkhome\/jobs\/query/,'post',(opt)=>Think.queryMyJops(opt));
//Mock.mock(/\/thinkhome\/fresh/,'post',(opt)=>Think.requestFreshPage(opt));
//Mock.mock(/\/thinkhome\/delete/,'post',(opt)=>Think.postHandleDelete(opt));
//Mock.mock(/\/thinkhome\/questions/,'post',(opt)=>Think.postQueryQuestions(opt));
//Mock.mock(/\/thinkhome\/questions/,'get',(opt)=>Think.getQueryQuestions(opt));
//Mock.mock(/\/thinkhome/,'get',(opt)=>Think.getOptions(opt));

