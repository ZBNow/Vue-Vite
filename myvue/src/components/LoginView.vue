<script setup>
import { ref } from "vue";
import { useStore } from "vuex";
import { useRouter } from "vue-router";
import { login } from "@/axios/requestRoot.js";

const store = useStore();
const router = useRouter();
// import { ElButton,ElInput} from 'element-plus';
const userInfo = ref({
  username: "",
  password: "",
});
const msg = ref("");
const headLogin = () => {
  //与后台通信
  let params = {
    username: userInfo.value.username,
    password: userInfo.value.password,
  };
  login(params).then((res) => {
      console.log("axios.then===>");
      //得到结果
      console.log(res);
      //分析结果
      //let {data}=res.data
      console.log(res.code);
      if (res.code === 200) {
        //结果正确，跳转到系统首页
        store.commit("User/setToken", res.data.token);
        store.commit("User/setUserName", res.data.username);
        console.log(store.getters["User/getToken"]);
        /*
                    store.commit();用于store对象的mutatioin来对state内容赋值
                    store.getters[];用于store对象的getters来获取state内容
                    store.dispatch();用于store对象的action来对state内容赋值
                */
        router.push({ name: "HomeFrame" });
      } else {
        //alert('用户名或密码不正确，请重新输入');
        //结果不正确，提示信息，清空输入
        
        userInfo.value.username = "";
        userInfo.value.password = "";
        
      }
    })
    .catch((err) => {
      console.log("axios catch===>");
      console.log(err);
      msg.value = "用户名或密码不正确，请重新输入";
      console.log("msg",msg);
    });
};
const handleInput = () => {
  msg.value = "";
};
</script>

<template>
  <div class="login_box">
    <div class="login_avatar">
      <img src="@/assets/bt.jpg" alt="bt" />
    </div>
    <el-form class="login_form" :model="userInfo">
      <el-form-item label="用户名：">
        <el-input
          v-model="userInfo.username"
          @input="handleInput()"
          placeholder="请输入账号"
        ></el-input>
      </el-form-item>
      <el-form-item label="密  码：">
        <el-input
          v-model="userInfo.password"
          type="password"
          placeholder="请输入密码"
        ></el-input>
      </el-form-item>
      <el-form-item>
        <div class="button">
          <el-button @click="headLogin()" type="primary">登录</el-button>
          <el-button type="info">重置</el-button>
          <el-button type="info"> 注册</el-button>
        </div>
      </el-form-item>
      <el-form-item>
        <p>{{ msg }}</p>
      </el-form-item>
    </el-form>
  </div>
</template>

<!--scoped 可以阻挡样式向下继承-->
<style scoped>
.login_box {
  width: 600px;
  height: 400px;
  border-radius: 10px;
  background-color: burlywood;
  position: absolute;
  left: 50%;
  top: 50%;
  transform: translate(-50%, -50%);
}
.login_avatar {
  width: 300px;
  height: 300px;
  background-color: chocolate;
  border-radius: 50%;
  border: 1px solid red;
  margin: 2px;
  box-sizing: border-box;
  position: absolute;
  transform: translate(50%, -50%);
  padding: 10px;
  z-index: 2;
}
img {
  height: 100%;
  width: 100%;
  border-radius: 50%;
}
.login_form {
  width: 100%;
  height: 250px;
  padding: 50px;
  background-color: chartreuse;
  border-radius: 10px;
  box-sizing: border-box;
  position: absolute;
  bottom: 0%;
  overflow: hidden;
  z-index: 1;
}
.button {
  width: 100%;
  height: 100%;
  background-color: aqua;
  display: flex;
  justify-content: center;
}
</style>
