<template>
  <h1>Categories</h1>
  <div class="category-list">
        <h3>{{ getCategory }}</h3> <!-- utan denna syns ej i localhost -->
      
        <div v-if="categories > 0">
            <CategoryCard
                v-for="(category, i) in categories"
                :key="i"
                :category="category"
            />
        </div>
    </div> 
</template>

<script>
import CategoryCard from "../components/CategoryCard.vue"

export default {
    name: 'CategoryCard.vue',
    components: {
        CategoryCard, 
        
    },

    computed: {
        getCategory() {
            console.log(this.getCategory);
            return this.$store.getters.getCategory

        }
    },

    // .dispatch() används när en påkallar en action:
    mounted() {
        this.$store.dispatch("fetchCategory");
    }
}
</script>

<style>

</style>


<!-- lär användas soon
<script>
import Category from "../components/Category.vue"
export default {
    name: "categoryListComponent",
    components: {
        Category,
    },

    computed: {
        categories(){
            return this.$store.state.categories;
        },
    },
    
};
</script>
--->

<!--
<div class="category-list">
        <div v-if="categories.length > 0">
            <Category

                v-for="(category, i) in categories"
                :key="i"
                :category="category"
            />
        </div>
    </div> --->