<template>
<div class="program-card">
<span>Id:{{program.id}} - {{program.name}}</span>
</div>
</template>

<script>
export default {
  props: ["program"],
    
}
</script>

<style>
.program-card {
  background-color: lightgray;
  margin-bottom: 20px;
  padding: 10px;
  font-family: 'Arial';
  border-radius: 30px;
  border: 5px solid whitesmoke;
}

</style>