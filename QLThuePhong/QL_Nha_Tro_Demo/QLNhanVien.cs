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
using System.Xml.Linq;

namespace QL_Nha_Tro_Demo
{
    public partial class QLNhanVien : Form
    {
        SqlConnection conn = new SqlConnection("data source=TN\\MINHTHANG;initial catalog=QLKSEZ;integrated security=True");
        SqlCommand cmd;
        SqlDataAdapter adapter;
        DataTable table = new DataTable();
        DataGridViewCellEventArgs vt;

        AES aes = new AES();

        public QLNhanVien()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            Close();
        }

        private void NhanVienPage_Load(object sender, EventArgs e)
        {
            txtname.Focus();
            khoamo(true);
            conn.Open();

            cmd = new SqlCommand("select * from NhanVien", conn);
            adapter = new SqlDataAdapter(cmd);

            DataTable dataTable = new DataTable();
            adapter.Fill(dataTable);

            //---------------------
            DecryptDataTable(dataTable, "tenNV", "gioiTinh","soDT", "email", "luong");

            dataGridView.DataSource = dataTable;

            conn.Close();
        }
        // Hàm giải mã dữ liệu DataTable với AES
        private void DecryptDataTable(DataTable table, params string[] columnNames)
        {
            foreach (DataRow row in table.Rows)
            {
                foreach (string columnName in columnNames)
                {
                    if (table.Columns.Contains(columnName))
                    {
                        row[columnName] = aes.GiaiMa(row[columnName].ToString());
                    }
                }
            }
        }

        public void khoacn(bool gt)
        {
            confirmfix.Enabled = gt;
            add.Enabled = gt;
            fix.Enabled = gt;
            del.Enabled = gt;
        }

        void loaddata()
        {
            cmd = conn.CreateCommand();
            cmd.CommandText = "select * from NhanVien";
            adapter.SelectCommand = cmd;
            table.Clear();
            adapter.Fill(table);
            dataGridView.DataSource = table;
        }
        public void xoatrangg()
        {
            // txtcode.Text = "";
            txtname.Text = "";
            txtdate.Text = "";
            txtsalary.Text = "";
            txtgender.Text = "";
            txtphone.Text = "";
            txtemail.Text = "";
        }

        private void dataGridView_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {
            conn.Open();
            if (dataGridView.RowCount <= 0) return;
            if (e.RowIndex >= 0)
            {
                vt = e;
                DataGridViewRow row = dataGridView.Rows[e.RowIndex];
                txtcode.Text = row.Cells[0].Value.ToString();
                txtname.Text = row.Cells[1].Value.ToString();
                txtdate.Text = row.Cells[2].Value.ToString();
                txtgender.Text = row.Cells[3].Value.ToString();
                txtphone.Text = row.Cells[4].Value.ToString();
                txtemail.Text = row.Cells[5].Value.ToString();
                txtsalary.Text = row.Cells[6].Value.ToString();
            }
            conn.Close();
        }

        private void exit_Click(object sender, EventArgs e)
        {
            Close();
        }

        private void clear_Click(object sender, EventArgs e)
        {
            // txtcode.Text = "";
            txtname.Text = "";
            txtdate.Text = "";
            txtsalary.Text = "";
            txtgender.Text = "";
            txtphone.Text = "";
            txtemail.Text = "";
        }

        public void khoamo(bool b)
        {
            add.Enabled = b;
            fix.Enabled = b;
            del.Enabled = b;
            exit.Enabled = b;

            
            clear.Enabled = !b;
            write.Enabled = !b;
            dontwrite.Enabled = !b;
            confirmfix.Enabled = !b;

            txtcode.ReadOnly = b;
            txtdate.ReadOnly = b;
            txtgender.Enabled = !b;
            txtname.ReadOnly = b;
            txtsalary.ReadOnly = b;
            txtphone.ReadOnly = b;
            txtemail.ReadOnly = b;
        }

        public void khoamofix(bool c)
        {
            add.Enabled= c;
            fix.Enabled = c;
            del.Enabled = c;
            exit.Enabled = c;

            clear.Enabled = !c;
            confirmfix.Enabled = !c;
            dontwrite.Enabled= !c;

            txtcode.ReadOnly = c;
            txtdate.ReadOnly = c;
            txtgender.Enabled = !c;
            txtname.ReadOnly = c;
            txtsalary.ReadOnly = c;
            txtphone.ReadOnly = c;
            txtemail.ReadOnly = c;
        }

        public void disablefix(bool a)
        {
            confirmfix.Enabled = !a;
        }

        private void add_Click(object sender, EventArgs e)
        {
            xoatrangg();
            khoamo(false);
            disablefix(true);
            txtname.Focus();
        }

        private void fix_Click(object sender, EventArgs e)
        {
            khoamofix(false);
            txtname.Focus();
        }

        private void del_Click(object sender, EventArgs e)
        {
            conn.Open();
            if (MessageBox.Show("Bạn có muốn xóa nhân viên [ " + txtname.Text + " ] không?", "Thông Báo", MessageBoxButtons.OKCancel, MessageBoxIcon.Question) == DialogResult.OK)
            {
                string queryString = @"DELETE FROM NhanVien WHERE tenNV = @tennhanvien";
                cmd.CommandText = queryString;

                cmd.Parameters.AddWithValue("@tennhanvien", txtname.Text);

                cmd.ExecuteNonQuery();
                loaddata();
                MessageBox.Show("Đã xóa nhân viên " + txtname.Text, "Thông Báo", MessageBoxButtons.OK, MessageBoxIcon.Information);
            } else
            {
                MessageBox.Show("Thất bại!!", "Thông Báo", MessageBoxButtons.OK, MessageBoxIcon.Information);
            }                            
            conn.Close();         
        }

        private void dontwrite_Click(object sender, EventArgs e)
        {
            try
            {
                xoatrangg();
                khoamo(true);
                dataGridView_CellContentClick(sender, vt);
            }
            catch (Exception)
            {

            }
        }

        private void write_Click(object sender, EventArgs e)
        {
            
            if (txtname.Text == "")
            {
                MessageBox.Show("Bạn chưa nhập họ tên", "Thông Báo", MessageBoxButtons.OK, MessageBoxIcon.Warning);
                txtname.Focus();
                return;
            }

            conn.Open();
            string queryString = @"INSERT INTO NhanVien (tenNV, NgaySinh, gioiTinh, soDT, email, luong) VALUES (@tennhanvien, @ngaysinh, @gioitinh, @sodienthoai, @email, @luong)";
            cmd.CommandText = queryString;
            
            // cmd.Parameters.AddWithValue("@manhanvien", txtcode.Text);
            cmd.Parameters.AddWithValue("@tennhanvien", aes.MaHoa(txtname.Text));
            cmd.Parameters.AddWithValue("@ngaysinh", txtdate.Text);
            cmd.Parameters.AddWithValue("@gioitinh", aes.MaHoa(txtgender.Text));
            cmd.Parameters.AddWithValue("@sodienthoai", aes.MaHoa(txtphone.Text));
            cmd.Parameters.AddWithValue("@email", aes.MaHoa(txtemail.Text));
            cmd.Parameters.AddWithValue("@luong", aes.MaHoa(txtsalary.Text));

            cmd.ExecuteNonQuery();
            loaddata();
            conn.Close();

            MessageBox.Show("Thêm Nhân Viên thành công", "Thông Báo", MessageBoxButtons.OK, MessageBoxIcon.Information);
            khoamo(true);
        }

        private void confirmfix_Click(object sender, EventArgs e)
        {
            conn.Open();
            if (txtname.Text == "")
            {
                MessageBox.Show("Bạn chưa nhập họ tên", "Thông Báo", MessageBoxButtons.OK, MessageBoxIcon.Warning);
                txtname.Focus();
                return;
            }

            string queryString = @"UPDATE NhanVien SET tenNV = @tennv, ngaySinh = @ngaysinh, gioiTinh = @gioitinh, soDT = @sodt, email = @email, luong = @luong WHERE maNV = @manhanvien";
            cmd.CommandText = queryString;

            cmd.Parameters.AddWithValue("@manhanvien", txtcode.Text);
            cmd.Parameters.AddWithValue("@tennv", aes.MaHoa(txtname.Text));
            cmd.Parameters.AddWithValue("@ngaysinh", txtdate.Text);
            cmd.Parameters.AddWithValue("@gioitinh", aes.MaHoa(txtgender.Text));
            cmd.Parameters.AddWithValue("@sodt", aes.MaHoa(txtphone.Text));
            cmd.Parameters.AddWithValue("@email", aes.MaHoa(txtemail.Text));
            cmd.Parameters.AddWithValue("@luong", aes.MaHoa(txtsalary.Text));

            cmd.ExecuteNonQuery();
            loaddata();
            conn.Close();

            MessageBox.Show("Sửa Nhân Viên thành công", "Thông Báo", MessageBoxButtons.OK, MessageBoxIcon.Information);
            khoamofix(true);
        }
    }
}
