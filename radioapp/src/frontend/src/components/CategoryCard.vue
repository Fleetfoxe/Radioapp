
<template>
    <div class="category-list">
        <span class="id">Id: {{ category.id }}</span> -
        <span class="name">Name: {{ category.name }}</span>
    </div>
</template>


<script>
export default {
    props: ["category"],
    
}
</script>


<style scoped>

.category-list {
  background-color: lightgray;
  margin-bottom: 20px;
  padding: 10px;
  font-family: 'Arial', cursive;
  border-radius: 30px;
  border: 5px solid whitesmoke;
}



</style>
