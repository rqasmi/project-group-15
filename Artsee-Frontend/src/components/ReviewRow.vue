<template>
  <section class="py-5" id="itemSection">
      <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-T8Gy5hrqNKT+hzMclPo118YTQO6cYprQmhrYwIiQ/3axmI1hQomh7Ud2hPOy8SP1" crossorigin="anonymous">
        <div class="container">
      <div class="row xl-6">
        <div class="col-md-8">
          <div class="card shadow">
            <div class="card-body">
              <div class="row text-center">
                <div id="stars">
                  <ReviewStars v-bind:rating= "rating"/>
                </div>
                <div class="col-md-6" id="infoBox">
                  <h4>{{artistName}}</h4> <h6> {{customerName}} </h6>
                  <p>{{comment}}</p>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
</template>

<script>
import ReviewStars from '@/components/ReviewStars'
import axios from 'axios'
var config = require('../../config')

var backendConfigurer = function(){
  switch(process.env.NODE_ENV){
      case 'development':
          return 'http://' + config.dev.backendHost + ':' + config.dev.backendPort;
      case 'production':
          return 'https://' + config.build.backendHost + ':' + config.build.backendPort ;
  }
};

var frontendConfigurer = function(){
  switch(process.env.NODE_ENV){
      case 'development':
          return 'http://' + config.dev.host + ':' + config.dev.port;
      case 'production':
          return 'https://' + config.build.host + ':' + config.build.port ;
  }
};
var backendUrl = backendConfigurer();
var frontendUrl = frontendConfigurer();

var AXIOS = axios.create({
  baseURL: backendUrl,
  //headers: { 'Access-Control-Allow-Origin': frontendUrl }
})

export default {

  props: {
    reviewID: {
      default: "notfound",
    }
  },
    components: {
      ReviewStars
  },
  name: "reviewRow",
  data() {
    return {
		rating: 0,
		comment: "",
		customerName: "Not Found",
		artistName: "Not Found",
    reviewError: "",
    };
  },
  created: function () {
    this.fetch()
  },

  methods: {
    fetch (){
      AXIOS.get('/reviews/' + this.reviewID.toString())
        .then(response => {
        // JSON responses are automatically parsed.
          this.rating = response.data.rating
          this.comment = response.data.comment
          this.artistName = response.data.artist.firstName + " " + response.data.artist.lastName
          this.customerName = response.data.customer.firstName + " " + response.data.customer.lastName
        })
        .catch(e => {
          var errorMsg = e.response.data
          console.log(errorMsg)
          this.reviewError = errorMsg
        })
    },
  }
};
</script>

<style scoped>
.container {
    background: transparent;
    max-width: 1000px;
}

#itemSection {
    background-color: white;
}

#infoBox{
    text-align: left;
}
#priceButton {
    margin-top: 20px;
}
</style>