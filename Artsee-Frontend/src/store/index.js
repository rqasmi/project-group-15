import Vuex from 'vuex';
import Vue from 'vue';
import login from './modules/login'
import artworkGallery from './modules/ArtworkGallery'

//Add Vuex to the Application
Vue.use(Vuex);

//Create store by binding all the modules
export default new Vuex.Store({
    modules: {
        login,
        artworkGallery,
    }
})