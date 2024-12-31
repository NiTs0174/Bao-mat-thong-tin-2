using QL_Nha_Tro_Demo.Entities;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Data.Entity;
using System.Data.SqlClient;
using System.Drawing;
using System.Linq;
using System.Net;
using System.Security.Cryptography;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Xml.Linq;

namespace QL_Nha_Tro_Demo
{
    public partial class QL_TaiKhoan : Form
    {
        Model1 db = new Model1();

        int lenh = 0;   //1 = thêm; 2 = sửa

        //---------------------------------------
        //BĂM MẬT KHẨU (MD5)
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

        void NapUser()
        {
            dataGridView1.DataSource = db.admins.Select(s => new { s.taikhoan, s.matkhau, s.role }).ToList();
        }

        public QL_TaiKhoan()
        {
            InitializeComponent();
        }
        // Phương thức để kiểm tra xem tên tài khoản đã tồn tại chưa
        private bool IsUsernameExists(string username, int? userId = null)
        {
            if (userId == null)
            {
                // Kiểm tra khi thêm mới
                return db.admins.Any(a => a.taikhoan == username);
            }
            else
            {
                // Kiểm tra khi sửa đổi (ngoại trừ tài khoản đang sửa)
                return db.admins.Any(a => a.taikhoan == username && a.acc != userId);
            }
        }
        //THIẾT KẾ NÚT
        public void khoamokh(bool tk)
        {
            btnThem.Enabled = tk;
            btnSua.Enabled = tk;
            btnExit.Enabled = tk;

            btnXoa.Enabled = !tk;
            btnCapNhat.Enabled = !tk;
            btnHuy.Enabled = !tk;

            groupBox1.Enabled = !tk;
        }
        public void khoamokhfix(bool tk)
        {
            btnCapNhat.Enabled = tk;

            btnXoa.Enabled = !tk;
        }
        public void khoamokhadd(bool tk)
        {
            btnCapNhat.Enabled = tk;

            btnXoa.Enabled = !tk;
        }
        public void khoamokhdel(bool tk)
        {
            btnXoa.Enabled = tk;

            btnHuy.Enabled = tk;            
        }
        //-------------------------------------------------------
        private void QL_TaiKhoan_Load(object sender, EventArgs e)
        {
            NapUser();

            khoamokh(true);
        }

        private void btnThem_Click(object sender, EventArgs e)
        {
            lenh = 1;

            khoamokh(false);
            khoamokhfix(true);
        }

        private void btnSua_Click(object sender, EventArgs e)
        {
            lenh = 2;

            khoamokh(false);
            khoamokhadd(true);
        }

        private void btnCapNhat_Click(object sender, EventArgs e)
        {
            if (lenh == 1)
            {
                // Kiểm tra xem tên tài khoản đã tồn tại chưa
                if (IsUsernameExists(txtUser.Text))
                {
                    MessageBox.Show("Tên tài khoản đã tồn tại. Vui lòng chọn tên tài khoản khác.", "Cảnh báo", MessageBoxButtons.OK, MessageBoxIcon.Warning);
                    return;
                }

                admin n = new admin();
                //n.acc = 1;
                n.taikhoan = txtUser.Text;
                n.matkhau = encryption(txtPass.Text);
                //n.matkhau = _3des.MaHoa(encryption((txtPass.Text)));
                n.role = Convert.ToInt32(txtRole.Text);
                db.admins.Add(n);

                db.SaveChanges();
                MessageBox.Show("Bạn vừa thêm thành công");
                NapUser();

                khoamokh(true);
            }
            else if (lenh == 2)
            {
                //Sửa đổi
                admin n = db.admins.SingleOrDefault(t => t.taikhoan == txtUser.Text);
                n.matkhau = encryption(txtPass.Text);
                //n.matkhau = _3des.MaHoa(encryption(txtPass.Text));
                n.role = Convert.ToInt32(txtRole.Text);

                db.SaveChanges();
                MessageBox.Show("Bạn đã sửa thành công!!");
                NapUser();

                khoamokh(true);
            }
        }

        private void dataGridView1_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {
            try
            {
                if (dataGridView1.Rows[e.RowIndex].Cells[e.ColumnIndex].Value != null)
                {
                    khoamokhdel(true);
                    dataGridView1.CurrentRow.Selected = true;
                    txtUser.Text = dataGridView1.Rows[e.RowIndex].Cells[0].Value.ToString();
                    txtPass.Text = dataGridView1.Rows[e.RowIndex].Cells[1].Value.ToString();
                    txtRole.Text = dataGridView1.Rows[e.RowIndex].Cells[2].Value.ToString();

                    btnSua.Enabled = true;
                    btnXoa.Enabled = true;
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message, "Lỗi", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
        }

        private void btnXoa_Click(object sender, EventArgs e)
        {
            try
            {
                if (MessageBox.Show("Bạn có muốn xóa khách hàng [ " + txtUser.Text + " ] không?", "Thông Báo", MessageBoxButtons.OKCancel, MessageBoxIcon.Question) == DialogResult.OK)
                {
                    admin n = db.admins.SingleOrDefault(t => t.taikhoan == txtUser.Text);
                    if (n != null)
                    {
                        db.admins.Remove(n);
                        db.SaveChanges();
                        MessageBox.Show("Bạn đã xóa tài khoản thành công!!");
                        NapUser();

                        btnSua.Enabled = true;
                        groupBox1.Enabled = false;
                        btnCapNhat.Enabled = false;
                    }
                    else
                    {
                        MessageBox.Show("Vui lòng nhập tài khoản cần xóa!!");
                    }
                }    

            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message, "Lỗi", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
        }

        private void btnHuy_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void btnHuy_Click_1(object sender, EventArgs e)
        {
            try
            {
                khoamokh(true);
            }
            catch (Exception)
            {
            }
        }
    }
}
