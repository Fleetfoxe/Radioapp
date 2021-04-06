import { createStore } from "vuex";

export default createStore({

    state: {
      channels: [
        {
  
          title: "P1",
  
          rating: 5,
  
          genre: "Pratradio",
  
          desc: "Radio med mycket snack",
  
        },
        {
  
          title: "P2",
  
          rating: 4,
  
          genre: "Klassisk musik",
  
          desc: "",
  
        }
      ],

      categories: [
        {
          name: "Comedy"
        },
        {
          name: "Drama"
        },
        {
          name: "Action"
        },
        {
          name: "Documentary"
        }
      ],

      programs: [
        {
          
        }
      ]
    },
    mutations:  {},
    actions: {},
    modules: {},

});