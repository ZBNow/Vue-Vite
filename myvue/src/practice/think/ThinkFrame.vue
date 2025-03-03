<script setup>
import { current } from './ThinkData.js';
</script>
<template>
    <KeepAlive>
        <component :is="current"></component>
    </KeepAlive>
</template>
<style scoped>

</style>