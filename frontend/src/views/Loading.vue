<template>
  <div id="loading_container">
    <img id="logo" :src="require(`@/assets/logo/logo3_size.gif`)" alt="logo"> 
  </div>
</template>

<script>
export default {
  name: 'LoadingPage',
}
</script>

<style scoped>
#loading_container {
  display: flex;
	justify-content: center;
	align-items: center;
	width: 100vw;
	height: 100vh;
	background-color: rgba(249, 250, 253);
	position: fixed;
	top: 0;
	left: 0;
	z-index: 9999;
}

#logo {
  display: flex;
	flex-direction: column;
	justify-content: center;
  width: 500px;
  height: 500px;
	/* background-color: white; */
	/* border-radius: 50%; */
}
</style>