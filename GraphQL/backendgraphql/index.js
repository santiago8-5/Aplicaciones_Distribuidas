const express = require("express");
const { ApolloServer } = require("apollo-server-express");
const mongoose = require("mongoose");
const typeDefs = require("./typeDefs");
const resolvers = require("./resolvers");

//Database Connection
const URL =
        //incorporar la cadena de conexión de mongodb
        "mongodb+srv://7561131662z:KPg6ZtVixnlD4nx7@cluster0.nesux0r.mongodb.net/"
mongoose.connect(

  URL,
  {
    useUnifiedTopology: true,
    useNewUrlParser: true,
  },
  () => console.log("DB CONNECTED")
);

const startServer = async () => {
  const app = express();
  const apolloServer = new ApolloServer({
    typeDefs,
    resolvers,
  });
  await apolloServer.start();
  apolloServer.applyMiddleware({ app: app });
  app.listen(4000, () => console.log("Server UP & RUnning *4000"));
  console.log("http://localhost:4000/graphql");
};
startServer();
