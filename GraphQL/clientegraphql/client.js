const { request, gql } = require('graphql-request');

// URL del servidor GraphQL
const endpoint = 'http://192.168.1.83:4000/graphql';

// Consulta GraphQL para obtener todos los posts
const queryPosts = gql`
  {
    mostrar {
      _id
      nombre
      apellidos
      edad
      pais
    }
  }
`;

// Consulta GraphQL para crear un nuevo post
const mutationCrearPost = gql`
  mutation CreateNewPost($post: PostInput!) {
    createPost(post: $post) {
      _id
      nombre
      apellidos
      edad
      pais
    }
  }
`;

// Función para mostrar los posts en la interfaz de usuario
async function mostrarPosts() {
  const data = await request(endpoint, queryPosts);
  const postsDiv = document.getElementById('posts');
  postsDiv.innerHTML = ''; // Limpiar contenido anterior
  data.mostrar.forEach(post => {
    const postElement = document.createElement('div');
    postElement.innerHTML = `
      <h3>${post.nombre} ${post.apellidos}</h3>
      <p>Edad: ${post.edad}</p>
      <p>País: ${post.pais}</p>
      <button onclick="eliminarPost('${post._id}')">Eliminar</button>
    `;
    postsDiv.appendChild(postElement);
  });
}

// Función para crear un nuevo post
async function crearPost(event) {
  event.preventDefault(); // Evitar que se recargue la página
  const nombre = document.getElementById('nombre').value;
  const apellidos = document.getElementById('apellidos').value;
  const edad = parseInt(document.getElementById('edad').value);
  const pais = document.getElementById('pais').value;
  const variables = { post: { nombre, apellidos, edad, pais } };
  await request(endpoint, mutationCrearPost, variables);
  mostrarPosts();
}

// Función para eliminar un post
async function eliminarPost(id) {
  const mutationEliminarPost = gql`
    mutation DeletePost($id: String!) {
      deletePost(id: $id)
    }
  `;
  const variables = { id };
  await request(endpoint, mutationEliminarPost, variables);
  mostrarPosts();
}

// Ejecutar la función para mostrar los posts al cargar la página
mostrarPosts().catch(error => console.error(error));

// Agregar un evento submit al formulario para crear un nuevo post
document.getElementById('form').addEventListener('submit', crearPost);
