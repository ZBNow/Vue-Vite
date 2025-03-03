<script setup>
import router from '../router';
import LayoutHeader from './LayoutHeader.vue';
import LayoutMenu from './LayoutMenu.vue';
</script>


<template>
    <div class="home">
        <header>
            <LayoutHeader></LayoutHeader>
        </header>
        <main>
            <div class="menu">
                <LayoutMenu></LayoutMenu>
            </div>
            <div class="client">
                <router-view></router-view>
            </div>
        </main>
    </div>
</template>


<style scoped>
.home{
    height: 100%;
    overflow: hidden;
    display: flex;
    flex-direction: column;
    >header{
        flex-shrink: 0;    
        height: 70px;
        width: 100%;
        margin:2px;
        background-color: antiquewhite;
    };
    >main{
        flex: 1;
        background-color: white;
        margin: 2px;
        display: flex;
        flex-direction: row;
        overflow: hidden;
        >.menu{
            height: 100%;
            margin: 2px;
            background-color: white;
            overflow: auto;
        }
        >.client{
            flex: 1;
            margin: 2px;
            background-color: azure;
            overflow: auto;
        }
    }
}
</style>