export default {
    namespaced:true,
    //这些数据在网页刷新后会丢失，所以需要存储到本地
    //使用localStorage存储token
    //使用vuex的state存储用户信息 
    state:{
        token:localStorage.getItem('myvue_token'),
        userInfor:{
            username:localStorage.getItem('myvue_username')
        }
    },
    getters:{
        isLogin(state){
            return !!state.token||!!localStorage.getItem('myvue_token');
        },
        getToken(state){
            return state.token;
        },
        getUserName(state){
            return state.userInfor.username;
        }
    },
    mutations:{
        setToken(state,token){
            state.token=token;
            localStorage.setItem('myvue_token',token);
        },
        clearAll(state){
            state.token='';
            localStorage.removeItem('myvue_token');
            localStorage.removeItem('myvue_username');
        },
        setUserName(state,username){
            state.userInfor.username=username;
            localStorage.setItem('myvue_username',username);
        }
    },
    actions:{},//有原子性的mutations
    modules:{}
};