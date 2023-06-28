<template id="supplier-view">
    <section>
        <div class="mb-3">
            <label for="supplier-id" class="form-label">ID</label>
            <input type="text" class="form-control" id="supplier-id" :value="supplier.id"
                   aria-describedby="supplierId" disabled>
        </div>
        <div class="mb-3">
            <label for="supplier-name" class="form-label">Name</label>
            <input type="text" class="form-control" id="supplier-name" :value="supplier.name"
                   aria-describedby="nameHelp" disabled>
        </div>
        <div class="mb-3">
            <label for="supplier-lastname" class="form-label">Lastname</label>
            <input type="text" class="form-control" id="supplier-lastname" :value="supplier.lastname"
                   aria-describedby="lastnameHelp" disabled>
        </div>
        <div class="mb-3">
            <label for="supplier-email" class="form-label">Email</label>
            <input type="email" class="form-control" id="supplier-email" :value="supplier.email"
                   aria-describedby="emailHelp" disabled>
        </div>
        <div class="mb-3">
            <label for="supplier-delivery-time" class="form-label">Delivery Time (In Days)</label>
            <input type="number" min="0" class="form-control" :value="supplier.deliveryTimeInDays"
                   id="supplier-delivery-time"
                   aria-describedby="deliveryTimeHelp" disabled>
        </div>
        <div class="mb-3">
            <label for="supplier-country" class="form-label">Country</label>
            <input type="text" class="form-control" id="supplier-country"
                   aria-describedby="countryHelp" :value="supplier.country" disabled>
        </div>
        <div class="mb-3">
            <label for="supplier-creation-at" class="form-label">Created At</label>
            <input type="text" class="form-control" id="supplier-creation-at"
                   aria-describedby="countryHelp" :value="supplier.createdAt" disabled>
        </div>
    </section>
</template>
<script>
app.component("supplier-view", {
  template: "#supplier-view",
  props: {
    supplier: Object
  }
});
</script>
<style>

</style>