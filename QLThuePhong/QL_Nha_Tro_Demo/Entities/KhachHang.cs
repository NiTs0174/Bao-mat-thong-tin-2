namespace QL_Nha_Tro_Demo.Entities
{
    using System;
    using System.Collections.Generic;
    using System.ComponentModel.DataAnnotations;
    using System.ComponentModel.DataAnnotations.Schema;
    using System.Data.Entity.Spatial;

    [Table("KhachHang")]
    public partial class KhachHang
    {
        [System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Usage", "CA2214:DoNotCallOverridableMethodsInConstructors")]
        public KhachHang()
        {
            ThuePhongs = new HashSet<ThuePhong>();
        }

        [Key]
        public int maKH { get; set; }

        [StringLength(50)]
        public string tenKH { get; set; }

        [StringLength(500)]
        public string diaChi { get; set; }

        [StringLength(15)]
        public string soDTKH { get; set; }

        [StringLength(50)]
        public string emailKH { get; set; }

        [StringLength(20)]
        public string gioiTinhKH { get; set; }

        [System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Usage", "CA2227:CollectionPropertiesShouldBeReadOnly")]
        public virtual ICollection<ThuePhong> ThuePhongs { get; set; }
    }
}
