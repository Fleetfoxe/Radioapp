<template>
<div class="channel-card" @click="redirectToChannelDetails">
  
   <h2>
  <!-- {{channel.name}} -->
      <img v-bind:src="channel.image">
       <!--{{channel.scheduleurl}} -->
      
  
   </h2>
</div>
</template>

<script>
export default {
  props:["channel"],

   methods: {
    redirectToChannelDetails() {
      this.$store.commit("setTempChannelName", this.channel.name)
    
      let routerUrl = '/channel-details/' + this.channel.id
      this.$router.push({path: routerUrl})
      
    }
  }
 
}
</script>


<style scoped>
.channel-card {
  background-color: lightgray;
  margin-bottom: 20px;
  padding: 10px;
  font-family: 'Arial';
  border-radius: 30px;
  border: 5px solid whitesmoke;
  }




</style>