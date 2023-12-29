import { makeStyles } from "@material-ui/core/styles";
import TextField from "@material-ui/core/TextField";
import { Paper, Button } from "@material-ui/core";
import { useEffect, useState } from "react";

const useStyles = makeStyles((theme) => ({
  root: {
    "& > *": {
      margin: theme.spacing(1),
    },
  },
}));

export default function Banktran() {
  const classes = useStyles();

  const [accno, setaccno] = useState("");

  const [acname, setacname] = useState("");

  const [bal, setbal] = useState("");

  const [account, setaccount] = useState([]);

  const paperStyle = { padding: "50px 20px", width: 400, margin: "20px auto" };

  useEffect(() => {
    fetch("http://localhost:8082/Listaccount")
      .then((res) => res.json())
      .then((result) => {
        setaccount(result);
      });
  }, []);

  const HandleClick = (e) => {
    e.preventDefault();
    const bank = { accno, acname, bal };
    console.log(bank);
    fetch("http://localhost:8082/newaccount", {
      method: "POST",
      headers: { "content-type": "application/json" },
      body: JSON.stringify(bank),
    }).then(() => {
      console.log("Account has been added");
    });
  };

  return (
    <container>
      <Paper elevation={3} style={paperStyle}>
        <h1 style={{ color: "blue" }}>
          <u>Balance Deposit</u>
        </h1>
        <form className={classes.root} noValidate autoComplete="off">
          <TextField
            id="outlined-basic"
            label="Account Number:"
            variant="outlined"
            fullWidth
            value={accno}
            onChange={(e) => setaccno(e.target.value)}
          />
          <TextField
            id="outlined-basic"
            label="Account Name:"
            variant="outlined"
            fullWidth
            value={acname}
            onChange={(e) => setacname(e.target.value)}
          />
          <TextField
            id="outlined-basic"
            label="Balance:"
            variant="outlined"
            fullWidth
            onChange={(e) => setbal(e.target.value)}
          />
          <Button variant="contained" color="secondary" onClick={HandleClick}>
            Submit
          </Button>
        </form>
      </Paper>

      <h1>Bank Accounts</h1>

      <Paper elevation={3} Style={paperStyle}>
      {
        account.map(acc=>(
          <Paper elevation={6} style={{margin:"10px",padding:"15px",textAlign:"left"}} key={acc.id}>

            Accno:{acc.accno}<br/>
            Acname:{acc.acname}<br/>
            Bal:{acc.bal}


          </Paper>
        ))
      }
      </Paper>
    </container>
  );
}
