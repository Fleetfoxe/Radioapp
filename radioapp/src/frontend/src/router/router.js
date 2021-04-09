import { createRouter, createWebHistory } from "vue-router";
import Home from "../views/Home.vue";
import ChannelList from "@/views/ChannelList";
import CategoryList from "@/views/CategoryList";
import ProgramList from "@/views/ProgramList"
import ProgramDetails from "@/views/ProgramDetails.vue"


const routes = [
  {
    path: "/",
    name: "Home",
    component: Home,
  },
  {
    path: "/channellist",
    component: ChannelList
  },
  {
    path: "/categorylist",
    component: CategoryList
  },
  {
    path: "/programlist",
    component: ProgramList
  },
  {
    path: "/program-details/:id",
    component: ProgramDetails
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
