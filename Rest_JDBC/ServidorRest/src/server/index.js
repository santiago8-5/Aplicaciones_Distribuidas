import "dotenv/config";
import express from "express";
import { createClient } from "@supabase/supabase-js";
import cors from "cors";

const app = express();

const supabaseUrl = process.env.JS_SUPABASE_URL;
const supabaseKey = process.env.JS_SUPABASE_KEY;
const supabase = createClient(supabaseUrl, supabaseKey);

app.use(cors());
app.use(express.json());
app.use(express.urlencoded({ extended: false }));

const getUsers = async () => {
  try {
    let { data, error } = await supabase.from("alumnos").select("*");

    if (error) throw error;

    return data;
  } catch (error) {
    throw error;
  }
};

const insertUser = async ({ user }) => {
  console.log("res", user);
  try {
    const { data, error } = await supabase
      .from("alumnos")
      .insert([user])
      .select();

    if (error) throw error;

    return data[0];
  } catch (error) {
    throw error;
  }
};

const updateUser = async ({ user }) => {
  const { id, ...dataUser } = user;
  try {
    const { data: user, error } = await supabase
      .from("alumnos")
      .update(dataUser)
      .eq("id", id)
      .select();

    if (error) throw error;

    return user[0];
  } catch (error) {
    throw error;
  }
};

const deleteUser = async (id) => {
  try {
    const { error } = await supabase.from("alumnos").delete().eq("id", id);

    if (error) throw error;

    return { message: "Dato elimado con exito" };
  } catch (error) {
    throw error;
  }
};

const validToken = (token) => {
  if (token !== "1234") throw "Error token invalido";
};

const handleRouteError = (handler) => async (req, res, next) => {
  try {
    await handler(req, res, next);
  } catch (error) {
    res.status(400).json({ res: error });
  }
};

// Select
app.get(
  "/users",
  handleRouteError(async (req, res) => {
    const data = await getUsers();
    res.status(200).json(data);
  })
);

// {data:{"id":0?,"nombre":""?}}
// Insert
app.post(
  "/user",
  handleRouteError(async (req, res) => {
    console.log(req.body)
    validToken(req.headers["token"]);
    const { data: user } = req.body;
    const data = await insertUser({ user });
    res.status(201).json({ data, message: "Dato insertado con exito" });
    console.log(user);

  })
);

// Update
app.put(
  "/user",
  handleRouteError(async (req, res) => {
    validToken(req.headers["token"]);
    const { data: user } = req.body;
    const data = await updateUser({ user });
    res.status(200).json({ data, message: "Dato modificado con exito" });
    console.log(user);
  })
);

// Delete
app.delete(
  "/user",
  handleRouteError(async (req, res) => {
    const { data } = req.body;
    const { message } = await deleteUser(data.id);
    res.status(201).json({ message });
  })
);

app.use("*", (req, res) =>
  res.status(401).json({ message: "Endpoint no valido" })
);



app.listen(3000, () => console.log("http://192.168.227.192:3000"));
 //192.168.227.192