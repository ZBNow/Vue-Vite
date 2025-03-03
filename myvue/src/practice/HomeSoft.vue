<script setup>

</script>
<template>
    <div class="page-container">
        <div class="title-container">
        
        </div>
        <div class="toolbar-container">
        
        </div>
        <div class="content-container">
        
        </div>
    </div>
</template>
<style scoped>
.page-container {
    height: 100%;
    overflow: hidden;
    background-color: aqua;
    margin: 2px;
    border-color: brown;
    display: flex;
    flex-direction: column;
    >.title-container{
        height: 50px;
        background-color: burlywood;
    }
    >.toolbar-container{
        height: 50px;
        background-color: cadetblue;
    }
    >.content-container{
        height: 100%;
        background-color: coral;
        flex: 1;
        overflow: auto;
    }
}
</style>