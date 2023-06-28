<template id="supplier-details">
    <dashboard-layout>
        <page-header title="Supplier Details"></page-header>
        <supplier-view :supplier="supplier"></supplier-view>
    </dashboard-layout>
</template>
<script>
app.component("supplier-details", {
  template: "#supplier-details",
  data: () => ({
    supplier: null,
  }),
  created() {
    const supplierId = this.$javalin.pathParams["supplierId"];
    fetch(`/api/v1/suppliers/${supplierId}`)
      .then(res => res.json())
      .then(res => this.supplier = res)
      .catch(() => alert("Error while fetching user"));
  }
});
</script>
<style>

</style>