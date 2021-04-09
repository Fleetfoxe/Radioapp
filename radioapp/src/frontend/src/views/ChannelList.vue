<template>
<h1>Channels</h1>
  <div class="channel-list">
        
    <div v-if="channels.length > 0">
      <ChannelCard 
        v-for="(channel, i) in channels"
        :key="channel + i"
        :channel="channel"
      /> 
    </div>
   </div>
</template>

<script>
import ChannelCard from "../components/ChannelCard.vue";

export default {
 
  components: {
    ChannelCard,
  },

  computed: {
    channels() {
            
            return this.$store.getters.getChannel
        },
    
  },
  mounted() {
        this.$store.dispatch("fetchChannel");
    }
};
</script>

<style>

</style>