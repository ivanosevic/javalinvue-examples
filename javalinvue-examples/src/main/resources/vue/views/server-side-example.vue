<template id="server-side-example">
  <dashboard-layout>
    <page-header title="Server Side Example"></page-header>
    <input type="text" :value="$javalin.state.message"/>
  </dashboard-layout>
</template>
<script>
app.component("server-side-example", {
  template: "#server-side-example"
});
</script>
<style>

</style>