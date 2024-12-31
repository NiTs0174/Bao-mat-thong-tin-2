namespace QL_Nha_Tro_Demo.Entities
{
    using System;
    using System.Collections.Generic;
    using System.ComponentModel.DataAnnotations;
    using System.ComponentModel.DataAnnotations.Schema;
    using System.Data.Entity.Spatial;

    [Table("Phong")]
    public partial class Phong
    {
        [System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Usage", "CA2214:DoNotCallOverridableMethodsInConstructors")]
        public Phong()
        {
            ThuePhongs = new HashSet<ThuePhong>();
        }

        [Key]
        public int maPhong { get; set; }

        [StringLength(50)]
        public string loaiPhong { get; set; }

        [StringLength(50)]
        public string tenPhong { get; set; }

        public int? giaPhong { get; set; }

        [StringLength(50)]
        public string tinhTrang { get; set; }

        [System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Usage", "CA2227:CollectionPropertiesShouldBeReadOnly")]
        public virtual ICollection<ThuePhong> ThuePhongs { get; set; }
    }
}
