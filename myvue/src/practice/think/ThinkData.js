import ThinkMyJobs from './ThinkMyJobs.vue';
import HomeThink from '../HomeThink.vue';
import Change from './Change.vue';
import Add from './Add.vue';

export const current = shallowRef(HomeThink);

export const TID = shallowRef(0);

export const changeCurrent=(name)=>{
     console.log("changeCurrent",name);
     if(name==='ThinkMyJobs'){
        current.value=ThinkMyJobs;
     }else if(name==='HomeThink'){
        current.value=HomeThink;
     }else if(name==='Change'){
        current.value=Change;
     }else if(name==='Add'){
      current.value=Add;
   }

}

