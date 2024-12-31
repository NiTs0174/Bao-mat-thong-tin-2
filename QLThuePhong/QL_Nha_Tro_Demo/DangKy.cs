using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Data.SqlClient;
using System.Drawing;
using System.Linq;
using System.Security.Cryptography;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace QL_Nha_Tro_Demo
{
    public partial class DangKy : Form
    {
        //----------------------------
        SqlConnection conn = new SqlConnection("data source=TN\\MINHTHANG;initial catalog=QLKSEZ;integrated security=True");
        SqlCommand cmd;
        SqlDataReader rdr;
        //---------------------------------------
        public string encryption(string password)
        {
            MD5CryptoServiceProvider md5 = new MD5CryptoServiceProvider();
            byte[] encrypt;
            UTF8Encoding encode = new UTF8Encoding();
            encrypt = md5.ComputeHash(encode.GetBytes(password));
            StringBuilder encryptData = new StringBuilder();
            for (int i = 0; i < encrypt.Length; i++)
            {
                encryptData.Append(encrypt[i].ToString());
            }
            return encryptData.ToString();
        }
        //-------------
        public DangKy()
        {
            InitializeComponent();
        }
        //--------------------------------------------------------
        private void btnRegistry_Click(object sender, EventArgs e)
        {
            string username = txtUser.Text;
            string password = txtPass.Text;
            string pass_encrypted = encryption(password);

            if (username.Length > 0 && password.Length > 0)
            {
                conn.Open();
                string sql = "Select * From admin Where [taikhoan]=@tenTK";
                cmd = new SqlCommand(sql, conn);
                cmd.Parameters.AddWithValue("@tenTK", username);
                rdr = cmd.ExecuteReader();
                if (rdr.Read())
                {
                    MessageBox.Show("Tên tài khoản đã tồn tại!!", "Thông Báo", MessageBoxButtons.OK, MessageBoxIcon.Information);
                    conn.Close();
                    return;
                }
                rdr.Close();

                try
                {
                    sql = "Insert Into admin ([taikhoan], [matkhau]]) Values (@tenTK, @matKhau)";
                    SqlCommand cmd2 = new SqlCommand(sql, conn);
                    cmd2.Parameters.AddWithValue("@tenTK", username);
                    cmd2.Parameters.AddWithValue("@matKhau", pass_encrypted);
                    cmd2.ExecuteNonQuery();
                    MessageBox.Show("Đăng ký thành công", "Thông Báo", MessageBoxButtons.OK, MessageBoxIcon.Information);
                }
                catch (Exception ex) {}
                conn.Close();
            }
        }
        //----------------------------------------------------
        private void btnExit_Click(object sender, EventArgs e)
        {
            login _login = new login();
            _login.Show();
        }
    }
}
