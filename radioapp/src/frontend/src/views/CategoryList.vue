<template>
<h1>Categories</h1>
  <div class="category-list">
        
    <div v-if="categories.length > 0">
      <CategoryCard 
        v-for="(category, i) in categories"
        :key="category + i"
        :category="category"
      /> 
    </div>
   </div>
</template>

<script>
import CategoryCard from "../components/CategoryCard.vue";

export default {
 
  components: {
    CategoryCard,
  },

  computed: {
    categories() {
            
            return this.$store.getters.getCategory
        },
    
  },
  mounted() {
        this.$store.dispatch("fetchCategory");
    }
};
</script>

<style>

</style>