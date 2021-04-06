<template>
  <div class="channel-list">

    <div v-if="channels.length > 0">
      <Channel
        v-for="(channel, i) in channels"
        :key="i"
        :channel="channel"
      />
    </div>

  </div>
</template>

<script>
import Channel from "../components/Channel.vue"
export default {
  name: 'channelListComponent',
  components: {
    Channel,
  },

  computed: {
    channels() {
      return this.$store.state.channels;
    },
  },
};
</script>

<style></style>
