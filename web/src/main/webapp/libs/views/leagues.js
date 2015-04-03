<script type="text/x-handlebars" data-template-name="leagues">
  <h1>Leagues</h1>
  <section id="main">
    <ul id="league-list">
      {{#each itemController="league"}}
        <li>
          <label>{{name}}</label>
        </li>
      {{/each}}
    </ul>
  </section>
  <a href="#" class="btn btn-primary">
      Create a new league
  </a>
</script>