<template>
<div class="channel-card" @click="redirectToChannelDetails">
  
   <h2>
   <span>{{channel.name}} </span> 
  
   </h2>
</div>
</template>

<script>
export default {
  props:["channel"],

   methods: {
    redirectToChannelDetails() {
      let routerUrl = '/channel-details/' + this.channel.id
      this.$router.push({path: routerUrl})
      
    }
  }
 
}
</script>


<style>

.channel-card {
  background-color: lightgray;
  margin-bottom: 20px;
  padding: 10px;
  font-family: 'Arial';
  border-radius: 30px;
  border: 5px solid whitesmoke;
  
}



</style>