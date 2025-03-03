<script setup>
import { changeCurrent } from './ThinkData';
import { changeRequestQuestion } from '../../axios/requestThink';
const handleMyReturn=()=>{
    //修改ThinkData.js中的showNo=1
    // showNo.value=1;
    msg.value = "";
    //console.log("handleMyReturn",msg);
    changeCurrent('HomeThink')
}
//要传的参数
const form=ref({
    id:0,
    LMC:'',
    title:'',
});
const msg = ref("");
const addQuestion=()=>{
    let question={
        type:'add',
        id:form.value.id,
        LMC:form.value.LMC,
        title:form.value.title};
    console.log("addQuestion",question);
    changeRequestQuestion(question).then(res=>{
        console.log(res);
        if(res.code===200){       
            console.log("success");
            msg.value = "添加成功";
            console.log("msg",msg);
            changeCurrent('HomeThink');
        }
    }).catch(err=>{
        msg.value = "数据格式错误，请重新输入";
        console.log("msg",msg);
        console.log(err);
    });
}
</script>

<template>
  <div class="page-container">
        <div class="title-container">
        <span>添加题目</span>
        </div>
        <div class="toolbar-container">
            <el-form :inline="true" :model="form" class="demo-form-inline">
                <el-form-item label="id">
                    <el-input
                        v-model="form.id"
                        style="width: 240px"
                        :rows="2"
                        type="textarea"
                        placeholder="Please input"
                    />
                </el-form-item>
                <el-form-item label="LMC">
                    <el-input
                        v-model="form.LMC"
                        style="width: 240px"
                        :rows="2"
                        type="textarea"
                        placeholder="Please input"
                    />
                </el-form-item>
                <el-form-item label="title">
                    <el-input
                        v-model="form.title"
                        style="width: 240px"
                        :rows="2"
                        type="textarea"
                        placeholder="Please input"
                    />
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="addQuestion()">确定</el-button>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="handleMyReturn()">取消/返回</el-button>
                </el-form-item>

                <el-form-item>
                    <p>{{ msg }}</p>
                </el-form-item>
            </el-form>
        </div>
    </div>
</template>

<style scoped>
/* 这里可以添加一些样式来美化页面，但在这个简化版中没有添加 */
</style>