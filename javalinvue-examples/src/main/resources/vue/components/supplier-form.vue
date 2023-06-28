<template id="supplier-form">
    <form>
        <div class="mb-3">
            <label for="supplier-name" class="form-label">Name</label>
            <input type="text" class="form-control" id="supplier-name" aria-describedby="nameHelp">
        </div>
        <div class="mb-3">
            <label for="supplier-lastname" class="form-label">Lastname</label>
            <input type="text" class="form-control" id="supplier-lastname" aria-describedby="lastnameHelp">
        </div>
        <div class="mb-3">
            <label for="supplier-email" class="form-label">Email</label>
            <input type="email" class="form-control" id="supplier-email" aria-describedby="emailHelp">
        </div>
        <div class="mb-3">
            <label for="supplier-delivery-time" class="form-label">Delivery Time</label>
            <input type="number" value="0" min="0" class="form-control" id="supplier-delivery-time"
                   aria-describedby="deliveryTimeHelp">
        </div>
        <div class="mb-3">
            <label for="supplier-delivery-time" class="form-label">Country</label>
            <select class="form-select" aria-label="Default select example">
                <option v-for="country in countries.data" :value="country.name">{{ country.name }}</option>
            </select>
        </div>
        <div class="mt-4">
            <button type="submit" class="btn btn-primary">Create Supplier</button>
        </div>
    </form>
</template>
<script>
app.component("supplier-form", {
  template: "#supplier-form",
  data: () => ({
    countries: new LoadableData("/api/v1/countries"),
  })
});
</script>
<style>

</style>