<script setup>
import LoginView from './components/LoginView.vue'
import {ref} from 'vue'
const obj=ref({
  name:'rose',
  age:20,
  lover:'222'
})
const items =ref([
  {
    name:'li',
    age:12
  },
  'ssss'
])
</script>

<template>
  <router-view></router-view>
  <!--
  <li v-for="(x,y,z) in obj" :key='y'>{{ x }}++{{ y }}++{{ z }}</li>
  <li v-for="(x,y,z) in items" :key='y'>{{ x }}++{{ y }}++{{ z }}</li>
  key是唯一索引值
  循环渲染
  -->
  <!--scoped 可以阻挡样式向下继承-->
</template>

<style>
   html,body{
    height:100%;
    background-color:white;
    overflow: hidden;
  }
  #app{
    width:100%;
    height:100%;
    overflow: hidden;
  }
</style>
