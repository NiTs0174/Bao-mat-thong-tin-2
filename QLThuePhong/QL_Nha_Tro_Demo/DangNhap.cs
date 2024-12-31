using System;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using System.Security.Cryptography;
using QL_Nha_Tro_Demo.Entities;

namespace QL_Nha_Tro_Demo
{
    public partial class login : Form
    {
        //VARIABLE-----------------------
        Model1 db = new Model1();

        //SqlConnection conn = new SqlConnection("data source=TN\\MINHTHANG;initial catalog=QLKSEZ;integrated security=True");
        //SqlCommand cmd;
        //SqlDataReader rdr;

        //METHOD------------        
        public login()
        {
            InitializeComponent();
        }

        public string encryption(string password)
        {
            MD5CryptoServiceProvider md5 = new MD5CryptoServiceProvider();
            byte[] encrypt;
            UTF8Encoding encode = new UTF8Encoding();
            encrypt = md5.ComputeHash(encode.GetBytes(password));
            StringBuilder encryptData = new StringBuilder();
            for (int i=0; i<encrypt.Length; i++)
            {
                encryptData.Append(encrypt[i].ToString());
            }
            return encryptData.ToString();
        }

        //EVENT----------------------------------------------------
        private void button1_Click(object sender, EventArgs e)
        {
            this.Close();
            Application.Exit();
        }

        private void loginbtn_Click(object sender, EventArgs e)
        {
            //cmd = new SqlCommand("select * from admin where taikhoan=@tenTK and matkhau=@matKhau", conn);
            //cmd.Parameters.AddWithValue("@tenTK", taikhoan.Text);
            //cmd.Parameters.AddWithValue("@matKhau", encryption(matkhau.Text));
            //conn.Open();            
            //rdr = cmd.ExecuteReader();

            string tdn = taikhoan.Text;
            string mk = encryption( matkhau.Text);
            admin n = db.admins.SingleOrDefault(t => t.taikhoan == tdn && t.matkhau == mk);


            if (n != null)//rdr.HasRows)
            {
                PhanQuyen.tdn = n.taikhoan;
                PhanQuyen.vt = Convert.ToInt32(n.role);

                MessageBox.Show("Đăng Nhập thành công", "Thông Báo" ,MessageBoxButtons.OK, MessageBoxIcon.Information);
                TrangChu dashBoad = new TrangChu();
                Hide();
                dashBoad.Show();
            }
            else
            {
                MessageBox.Show("Đăng Nhập thất bại, vui lòng nhập lại Tài Khoản hoặc Mật Khẩu", "Thông Báo", MessageBoxButtons.OK, MessageBoxIcon.Error);

                taikhoan.Text = "";
                matkhau.Text = "";
                taikhoan.Focus();
            }

            //conn.Close();
        }

        private void login_Load(object sender, EventArgs e)
        {
            Show();
            taikhoan.Focus();
        }
    }
}
